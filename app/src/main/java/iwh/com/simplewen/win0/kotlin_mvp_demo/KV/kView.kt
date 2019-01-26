package iwh.com.simplewen.win0.kotlin_mvp_demo.KV

/**
 * 视图层
 * 操作androidUI
 * 将UI操作从activity剥离出来
 * activity做具体实现
 */
interface kView{

    /**
     * show 进度圈
     */
    fun showLoad()

    /**
     * hide 进度圈
     */
    fun hideLoad()

    /**
     * show 文本与
     */
    fun showSnackBar(showText:String)
}