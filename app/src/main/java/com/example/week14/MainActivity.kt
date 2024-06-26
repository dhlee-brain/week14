package com.example.week14

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.week14.ui.theme.Week14Theme

class MainActivity : ComponentActivity() {
    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
    }
    override fun onStart() {
        super.onStart()
        Log.i("test", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("test", "onResume")
    }

    override fun onPause(){
        super.onPause()
        Log.i("test", "onPause")
    }

    override fun onStop(){
        super.onStop()
        Log.i("test", "onStop")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.i("test", "onDestroy")
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("test", "onCreate")
        setContent {
            Week14Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    var brmsg by remember {
        mutableStateOf("")
    }

    SystemBroadcastReceiver(
        systemAction = Intent.ACTION_POWER_CONNECTED
    ){
        val action = it?.action?:return@SystemBroadcastReceiver
        brmsg = "충전 시작"
    }

    SystemBroadcastReceiver(
        systemAction = Intent.ACTION_POWER_DISCONNECTED
    ){
        val action = it?.action?:return@SystemBroadcastReceiver
        brmsg = "충전 해제"
    }

    Column {
        Text(text = "수신 메시지")
        Text(text =brmsg)
    }
}

/* 블루투스 등 메시지를 수신하고 싶으면 브로드캐스트 수신자를 활용해야 한다.
* 카드 쓰면 카드 메시지 캐치해서 파싱, 가계부에 반영할 수 있다.
*
*
* */