package iwh.com.simplewen.win0.kotlin_mvp_demo.KP

import android.os.Handler
import android.os.Looper
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import iwh.com.simplewen.win0.kotlin_mvp_demo.APP.work.showData
import iwh.com.simplewen.win0.kotlin_mvp_demo.APP.work.showDataListerer
import iwh.com.simplewen.win0.kotlin_mvp_demo.KV.kView
import java.lang.Exception
import java.lang.invoke.MethodHandles

/**
 * Presenter层
 * 负责事件处理与数据请求（网络请求）
 * 负责具体执业务逻辑
 * @param kview V层实例
 * 活动继承了V层，将活动对象传当做kView传给kP
 * 链接：V与P层
 */
class kP(var kview: kView) {
    //这里实例一个业务操作实例
    val showData = showData()
    //新线程的Handler对象
    private var mHandler: Handler

    init {
        this.mHandler = Handler(Looper.getMainLooper())

    }
    //开始执行业务请求
    fun toStart() {
        //活动的进度圈控制：显示
        kview.showLoad()
        //使用Object 匿名内部类
        showData.getData(object : showDataListerer {
            override fun resError(e: Exception) {
                //调用活动的方法
                kview.showSnackBar(e.toString())
            }

            override fun resOk(data: MutableMap<String, String>) {
                mHandler.post {
                    kview.hideLoad()
                    kview.showSnackBar(data["name"]!!)
                }
            }
        })
    }


}