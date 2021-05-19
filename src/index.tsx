import * as React from 'react';
import { ImageBackground, NativeModules } from 'react-native';

const { Blurshot } = NativeModules;

export default function (props: any) {
  const [result, setResult] = React.useState<string>('');
  Blurshot.screenshot().then(setResult);
  console.log(result);

  return result ? (
    <ImageBackground
      imageStyle={{ alignItems: 'flex-start' }}
      blurRadius={props.blurRadius}
      resizeMode={'stretch'}
      source={{ uri: `data:image/png;base64,${result}` }}
      style={{ flex: 1 }}
    >
      {props.children}
    </ImageBackground>
  ) : (
    <></>
  );
}
