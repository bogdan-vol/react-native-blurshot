import * as React from 'react';

import { View, Text } from 'react-native';
import Blurshot from 'react-native-blurshot';

export default function App() {
  return (
    <View style={{ flex: 1 }}>
      <View style={{ flexDirection: 'row', flexWrap: 'wrap' }}>
        {[1, 2, 3, 4, 5, 6, 7, 8, 9, 10].map((i) => (
          <View style={{ width: '25%', padding: 10 }} key={i}>
            <View
              style={{
                height: 50,
                width: '100%',
                backgroundColor: 'red',
              }}
            />
          </View>
        ))}
      </View>
      <Blurshot blurRadius={15}>
        <Text style={{ textAlign: 'center' }}>PPP</Text>
      </Blurshot>
    </View>
  );
}
