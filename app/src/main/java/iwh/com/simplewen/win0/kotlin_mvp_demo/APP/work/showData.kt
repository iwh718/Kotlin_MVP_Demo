package iwh.com.simplewen.win0.kotlin_mvp_demo.APP.work
import java.lang.Exception
import kotlin.concurrent.thread

/**
 * 业务具体实现类
 */
class showData: showWorrk {

    /**
     * 继承 showWork 实现 数据请求
     * @param showDataListerer 数据请求监听器
     */
    override fun getData(showDataListerer: showDataListerer) {
        //这里是用得 thread 可以省略 start（）
        thread{
            //模拟耗时
            Thread.sleep(2000)
            try {
                //该监听器负责处理请求结果
                showDataListerer.resOk( mutableMapOf("name" to "IWH"))
            }catch (e:Exception){
                showDataListerer.resError(e)
            }

        }

    }

}