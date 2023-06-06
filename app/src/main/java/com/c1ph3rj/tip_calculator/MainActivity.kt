package com.c1ph3rj.tip_calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.c1ph3rj.tip_calculator.ui.theme.Tip_calculatorTheme
import com.c1ph3rj.tip_calculator.ui.theme.appColor8

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tip_calculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    TipCalculatorApp()
                }
            }
        }
    }
}

@Composable
fun TipCalculatorApp() {
    var noOfPersons by remember {
        mutableStateOf(0)
    }
    var totalAmount by remember {
        mutableStateOf("")
    }
    val totalAmountToBeSplit by remember {
        mutableStateOf("₹ 0.00")
    }
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            Box(modifier = Modifier.padding(10.dp)) {
                Card(
                    shape = RoundedCornerShape(12.dp),
                    elevation = 8.dp,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .background(
                                appColor8
                            )
                            .padding(horizontal = 8.dp, vertical = 20.dp)
                    ) {
                        Text(
                            text = "Total Per Person",
                            modifier = Modifier.fillMaxWidth(),
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 25.sp
                        )
                        Text(
                            text = totalAmountToBeSplit,
                            modifier = Modifier.fillMaxWidth(),
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 25.sp
                        )
                    }
                }
            }
            Card(
                border = BorderStroke(2.dp, Color.LightGray), shape = RoundedCornerShape(8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                ) {
                    OutlinedTextField(value = totalAmount,
                        onValueChange = { billAmount -> totalAmount = billAmount },
                        modifier = Modifier.fillMaxWidth(),
                        label = {
                            Text(text = "Bill", fontWeight = FontWeight.SemiBold)
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        placeholder = { Text(text = "Enter the total Bill Amount") },
                        leadingIcon = { Text(text = "₹", fontWeight = FontWeight.SemiBold) })
                    Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth().height(60.dp), verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "Split", modifier = Modifier.weight(1f), fontWeight = FontWeight.SemiBold)
                        Row (horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically) {
                            Button(onClick = {
                                if (noOfPersons > 0) {
                                    noOfPersons -= 1
                                }
                            }, shape = RoundedCornerShape(360.dp), modifier = Modifier.size(40.dp)) {
                                Text(text = "-")
                            }
                            Text(text = noOfPersons.toString(), fontWeight = FontWeight.SemiBold)
                            Button(onClick = {
                                noOfPersons += 1
                            }, shape = RoundedCornerShape(360.dp), modifier = Modifier.size(40.dp)) {
                                Text(text = "+")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Tip_calculatorTheme {
        TipCalculatorApp()
    }
}