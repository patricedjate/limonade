package com.example.limonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.limonade.ui.theme.LimonadeTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LimonadeTheme {
                LemonApp()
            }
        }
    }
}
@Composable
fun LemonApp(modifier : Modifier = Modifier){
    LemonWithButtonAndImage(
       // modifier
         //   .fillMaxSize()
          //  .wrapContentSize(Alignment.Center)

    )

}
@Composable
fun LemonWithButtonAndImage(modifier : Modifier = Modifier){
    var result by remember { mutableStateOf(1) }
    var tap by remember { mutableStateOf(1) }

    val imageResource = when (result) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val textResource = when (result) {
        1 -> R.string.re1
        2 -> R.string.re2
        3 -> R.string.re3
        else -> R.string.re4
    }
    Column (
        modifier
            .background(color = Color.Yellow)
            .fillMaxWidth(),
   horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text("Limonade")


    }
  Column (
      modifier
      .fillMaxSize()
      .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally,

    ){


            Image(
                painter = painterResource(imageResource),
                contentDescription ="image $result",
                modifier
                    .wrapContentSize()
                    //.background(color = Color.Gray)
                    .clickable {
                       // result+=1

                        if(result==1){
                            tap = (2..6).random()
                            result+=1
                        }
                        if(result==2 && tap==0){
                            result+=1
                        }else if (tap > 1 ){
                            tap--
                        }else{
                            result+=1
                        }
                        if (result>4){
                            result = 1
                        }
                    }


                )
      Spacer(modifier.height(16.dp))
      Text(stringResource(textResource),
          //fontWeight = FontWeight.Bold,
          fontSize = 18.sp,)

          //modifier.padding(bottom = 100.dp))
      //(stringResource(textResource),)

      //Spacer(modifier.height(16.dp))




    }



}

@Preview(showBackground = true)
@Composable
fun LemonPreview() {
    LimonadeTheme {
        LemonApp()
    }
    }


