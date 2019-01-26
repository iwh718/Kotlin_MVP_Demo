package iwh.com.simplewen.win0.kotlin_mvp_demo.APP

import android.app.Application
import android.content.Context

class kApp:Application(){

    companion object {
        var Kcontext:Application? = null
       // fun getContext() = Kcontext
    }

    override fun onCreate() {
        super.onCreate()
        Kcontext = this
    }


}