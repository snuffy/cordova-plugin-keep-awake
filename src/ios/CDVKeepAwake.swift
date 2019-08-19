

@objc(CDVKeepAwake) class CDVKeepAwake : CDVPlugin {
  override func pluginInitialize() {
    print("hi");
  };

  @objc func start(_ command: CDVInvokedUrlCommand) {
    print("hi start");
  }

  @objc func stop(_ command: CDVInvokedUrlCommand) {
    print("hi stop");
  }
}