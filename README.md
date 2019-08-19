# cordova-plugin-keep-awake


Using this plug-in, you can control the automatic sleep at any time.

## Installation

Install the plugin by adding it to your project's config.xml:

```
<plugin name="cordova-plugin-firebasex" spec="latest" />
```

or by using cordova CLI

cordova plugin add cordova-plugin-firebasex


## Usage

```js

// start keep awaking
if (window.KeepAwake) {
  KeepAwake.start();
}

// stop keep awaking
if (window.KeepAwake) {
  KeepAwake.stop();
}
```