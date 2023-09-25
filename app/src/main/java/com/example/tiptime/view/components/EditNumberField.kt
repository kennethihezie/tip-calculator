package com.example.tiptime.view.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.example.tiptime.R
import com.example.tiptime.utils.Utils

/*
To denote that the label parameter is expected to be a string resource reference,
annotate the function parameter with the @StringRes annotation
 */
@Composable
fun EditNumberField(value: String, onValueChange: (String) -> Unit, modifier: Modifier = Modifier, @StringRes label: Int, imeAction: ImeAction, @DrawableRes leadingIcon: Int) {
    TextField(
        label = { Text(text = stringResource(id = label)) },
        singleLine = true,
        leadingIcon = { Icon(painter = painterResource(id = leadingIcon), contentDescription = null)},
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number,
            imeAction = imeAction
        ),
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
    )
}