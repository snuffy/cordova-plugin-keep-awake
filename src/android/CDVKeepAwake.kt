package jp.rabee

import org.apache.cordova.*
import org.json.JSONException
import android.util.Log
import android.view.WindowManager
import org.json.*


class CDVKeepAwake : CordovaPlugin() {
    lateinit var context: CallbackContext

    // 別の callback context を用意する
    lateinit var onProgressCallbackContext: CallbackContext

    // アプリ起動時に呼ばれる
    override public fun initialize(cordova: CordovaInterface,  webView: CordovaWebView) {
        LOG.d(TAG, "hi! This is CDVKeepAwake. Now intitilaizing ...");
    }


    // js 側で関数が実行されるとこの関数がまず発火する
    override fun execute(action: String, data: JSONArray, callbackContext: CallbackContext): Boolean {
        context = callbackContext
        var result = true
        when(action) {
            "start" -> {
                result = this.start(context)
            }
            "stop" -> {
                result = this.stop(context)
            }
            else -> {
                // TODO error
            }
        }


        return result
    }

    // 画面光らせるスタート
    private fun start(callbackContext: CallbackContext): Boolean {
        val activity = cordova.activity;
        // ui thread でしか実行できないので、UIスレッドで実行する
        activity.runOnUiThread() {
            activity.window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
            val result = PluginResult(PluginResult.Status.OK, true)
            callbackContext.sendPluginResult(result)

        }
        return true;
    }

    // 画面光らせないストップ
    private fun stop(callbackContext: CallbackContext): Boolean {
        val activity = cordova.activity;
        // ui thread でしか実行できないので、UIスレッドで実行する
        activity.runOnUiThread() {
            activity.window.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            val result = PluginResult(PluginResult.Status.OK, true)
            callbackContext.sendPluginResult(result)

        }
        return true;
    }

    companion object {
        protected val TAG = "CDVKeepAwake"
    }
}