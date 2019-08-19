'use strict';

var exec = require('cordova/exec');

// cordova exec
var _KeepAwake = {
  start: (onSuccess, onFail, param) => {
    return exec(onSuccess, onFail, 'KeepAwake', 'start', [param]);
  },
  stop: (onSuccess, onFail, param) => {
    return exec(onSuccess, onFail, 'KeepAwake', 'stop', [param]);
  },
};

// Promise wrapper
var KeepAwake = {
  start: (params) => {
    return new Promise((resolve, reject) => {
      _KeepAwake.start((res) => {
        resolve(res);
      }, (err) => {
        reject(err);
      }, params);
    });
  },
  stop: (params) => {
    return new Promise((resolve, reject) => {
      _KeepAwake.stop((res) => {
        resolve(res);
      }, (err) => {
        reject(err);
      }, params);
    });
  },
}

module.exports = KeepAwake;
