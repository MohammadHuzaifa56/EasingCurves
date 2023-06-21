package com.example.easingcurves

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.EaseInOutBack
import androidx.compose.animation.core.EaseInOutCubic
import androidx.compose.animation.core.EaseInOutQuart
import androidx.compose.animation.core.EaseOutBounce
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.easingcurves.ui.theme.EasingCurvesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EasingCurvesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        val linearEasingAngle by rememberInfiniteTransition().animateFloat(
                            initialValue = 0f,
                            targetValue = 1440f,
                            animationSpec = infiniteRepeatable(
                                tween(
                                    durationMillis = 4000,
                                    easing = LinearEasing,
                                    delayMillis = 1000
                                ),
                                repeatMode = RepeatMode.Restart
                            )
                        )

                        val easeInOutAngle by rememberInfiniteTransition().animateFloat(
                            initialValue = 0f,
                            targetValue = 1440f,
                            animationSpec = infiniteRepeatable(
                                tween(
                                    durationMillis = 4000,
                                    easing = EaseInOut,
                                    delayMillis = 1000
                                ),
                                repeatMode = RepeatMode.Restart
                            )
                        )

                        val easeOutBounceAngle by rememberInfiniteTransition().animateFloat(
                            initialValue = 0f,
                            targetValue = 1440f,
                            animationSpec = infiniteRepeatable(
                                tween(
                                    durationMillis = 4000,
                                    easing = EaseOutBounce,
                                    delayMillis = 1000
                                ),
                                repeatMode = RepeatMode.Restart
                            )
                        )

                        val easeInBackAngle by rememberInfiniteTransition().animateFloat(
                            initialValue = 0f,
                            targetValue = 1440f,
                            animationSpec = infiniteRepeatable(
                                tween(
                                    durationMillis = 4000,
                                    easing = EaseInOutBack,
                                    delayMillis = 1000
                                ),
                                repeatMode = RepeatMode.Restart
                            )
                        )

                        val easeInOutQuart by rememberInfiniteTransition().animateFloat(
                            initialValue = 0f,
                            targetValue = 1440f,
                            animationSpec = infiniteRepeatable(
                                tween(
                                    durationMillis = 4000,
                                    easing = EaseInOutQuart,
                                    delayMillis = 1000
                                ),
                                repeatMode = RepeatMode.Restart
                            )
                        )

                        val easeInOutCubic by rememberInfiniteTransition().animateFloat(
                            initialValue = 0f,
                            targetValue = 1440f,
                            animationSpec = infiniteRepeatable(
                                tween(
                                    durationMillis = 4000,
                                    easing = EaseInOutCubic,
                                    delayMillis = 1000
                                ),
                                repeatMode = RepeatMode.Restart
                            )
                        )
                        Row(
                            Modifier
                                .fillMaxWidth()
                        ) {
                            FanView(
                                modifier = Modifier
                                    .weight(1f), title = "Linear", angle = linearEasingAngle
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            FanView(
                                modifier = Modifier
                                    .weight(1f), title = "EaseInOut", angle = easeInOutAngle
                            )
                        }
                        Spacer(modifier = Modifier.height(40.dp))
                        Row(
                            Modifier
                                .fillMaxWidth()
                        ) {
                            FanView(
                                modifier = Modifier
                                    .weight(1f), title = "EaseInOutQuart", angle = easeInOutQuart
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            FanView(
                                modifier = Modifier
                                    .weight(1f), title = "EaseInOutCubic", angle = easeInOutCubic
                            )
                        }
                        Spacer(modifier = Modifier.height(40.dp))
                        Row(
                            Modifier
                                .fillMaxWidth()
                        ) {
                            FanView(
                                modifier = Modifier
                                    .weight(1f), title = "EaseInBack", angle = easeInBackAngle
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            FanView(
                                modifier = Modifier
                                    .weight(1f), title = "EaseOutBounce", angle = easeOutBounceAngle
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun FanView(modifier: Modifier, title: String, angle: Float) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_fan_wings), modifier = Modifier
                .size(48.dp)
                .rotate(angle), contentDescription = ""
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = title, color = Color.Black, fontSize = 14.sp)
    }
}