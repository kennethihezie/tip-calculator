/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.tiptime.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tiptime.R
import com.example.tiptime.ui.theme.TipTimeTheme
import com.example.tiptime.utils.Utils
import com.example.tiptime.view.components.EditNumberField
import com.example.tiptime.view.components.RoundTheTipRow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipTimeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TipTimeLayout()
                }
            }
        }
    }
}

@Composable
fun TipTimeLayout() {
    var amountInput by remember {
        mutableStateOf("")
    }
    var tipInput by remember {
        mutableStateOf("")
    }
    var roundUp by remember {
        mutableStateOf(false)
    }
    val amount = amountInput.toDoubleOrNull() ?: 0.0
    val tipPercent = tipInput.toDoubleOrNull() ?: 0.0

    val tip = Utils.calculateTip(amount, tipPercent = tipPercent, roundUp = roundUp)

    /*
     .verticalScroll(rememberScrollState()) to the modifier to enable the column
     to scroll vertically. The rememberScrollState() creates and automatically
     remembers the scroll state
     */
    Column(
        modifier = Modifier
            .padding(40.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = stringResource(R.string.calculate_tip),
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(alignment = Alignment.Start)
        )

        EditNumberField(label = R.string.bill_amount, imeAction = ImeAction.Next, leadingIcon = R.drawable.money, value = amountInput, onValueChange = { amountInput = it }, modifier = Modifier
            .padding(bottom = 32.dp)
            .fillMaxWidth())

        EditNumberField(label = R.string.how_was_the_service, imeAction = ImeAction.Done, leadingIcon = R.drawable.percent, value = tipInput, onValueChange = { tipInput = it }, modifier = Modifier
            .padding(bottom = 32.dp)
            .fillMaxWidth())

        RoundTheTipRow(modifier = Modifier, checked = roundUp, onCheckedChange = { roundUp = it}, label = R.string.round_up_tip)

        Text(
            text = stringResource(R.string.tip_amount, tip),
            style = MaterialTheme.typography.displaySmall
        )

        Spacer(modifier = Modifier.height(150.dp))
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TipTimeLayoutPreview() {
    TipTimeTheme {
        TipTimeLayout()
    }
}
