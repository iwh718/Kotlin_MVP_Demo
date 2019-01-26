package iwh.com.simplewen.win0.kotlin_mvp_demo.APP.work

import java.lang.Exception

/**
 * 数据请求监听器
 */
interface showDataListerer {
    /**
     * 请求ok
     * @param data 接收数据
     */
    fun resOk(data:MutableMap<String,String>)

    /**
     * 请求error
     */
    fun resError(e:Exception)
}