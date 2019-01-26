package iwh.com.simplewen.win0.kotlin_mvp_demo.KV

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import iwh.com.simplewen.win0.kotlin_mvp_demo.KP.kP
import iwh.com.simplewen.win0.kotlin_mvp_demo.R

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

/**
 * @author IWH
 * @time 2019.01.26
 * Kotlin版最简MVP
 * QQ群：943543759
 * 继承 kView接口，即View层，并实现该接口负责的UI操作
 * 具体，请看kView接口
 */
class MainActivity : AppCompatActivity(), kView {
    //helloWorld组件
    lateinit var kShowTextView: TextView
    //进度条
    lateinit var kProgressBar: ProgressBar
    //Kp：Presenter层实实例
    lateinit var kP: kP

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        //获取进度条实例
        kProgressBar = kProgressBarId
        //获取P层实例
        kP = kP(this)
        //获取helloWord实例
        kShowTextView = showTextViewId
        //fab负责启动
        fab.setOnClickListener {
            kP.toStart()
            //转向:kP类查看
        }

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun showLoad() {
        kProgressBar.visibility = View.VISIBLE
    }


    override fun hideLoad() {
        kProgressBar.visibility = View.GONE
    }

    override fun showSnackBar(showText: String) {
        Snackbar.make(kProgressBar, showText, Snackbar.LENGTH_LONG).show()
        kShowTextView.text = "姓名：$showText"
    }


}
