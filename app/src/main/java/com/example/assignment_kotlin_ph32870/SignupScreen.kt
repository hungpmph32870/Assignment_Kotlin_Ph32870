package com.example.assignment_kotlin_ph32870

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class SignupScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignupSc()
        }
    }
}
@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupSc(){
    var name_signup by remember { mutableStateOf("") }
    var email_signup by remember { mutableStateOf("") }
    var password_signup by remember { mutableStateOf("") }
    var passwordVisible_signup by remember { mutableStateOf(false) }
    var confirm_password_signup by remember { mutableStateOf("") }
    var confirm_passwordVisible_signup by remember { mutableStateOf(false) }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Divider(
                color = Color.Black,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(100.dp)
                    .padding(bottom = 10.dp),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.width(8.dp))
            Divider(
                color = Color.Black,
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "WELCOME", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(30.dp))
        TextField(
            value = name_signup,
            onValueChange = { name_signup = it },
            label = { Text("Name") },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        )

        Spacer(modifier = Modifier.height(30.dp))
        TextField(
            value = email_signup,
            onValueChange = { email_signup = it },
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        )

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = password_signup,
            onValueChange = { password_signup = it },
            label = { Text("Password") },
            visualTransformation = if (passwordVisible_signup) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if (passwordVisible_signup)
                    ImageVector.vectorResource(id = R.drawable.baseline_visibility_24)
                else
                    ImageVector.vectorResource(id = R.drawable.baseline_visibility_off_24)

                IconButton(onClick = { passwordVisible_signup = !passwordVisible_signup }) {
                    Icon(imageVector = image, contentDescription = null)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        )

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = confirm_password_signup,
            onValueChange = { confirm_password_signup = it },
            label = { Text("Confirm password") },
            visualTransformation = if (confirm_passwordVisible_signup) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if (confirm_passwordVisible_signup)
                    ImageVector.vectorResource(id = R.drawable.baseline_visibility_24)
                else
                    ImageVector.vectorResource(id = R.drawable.baseline_visibility_off_24)

                IconButton(onClick = { confirm_passwordVisible_signup = !confirm_passwordVisible_signup }) {
                    Icon(imageVector = image, contentDescription = null)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = Color.DarkGray
            )
        ) {
            Text(text = "SIGN UP", color = Color.White)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row {
            Text(
                text = "Already have account?",
                color = Color(0xFFAFB4B9),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable { }
            )
            Text(
                text = " SIGN IN",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable { }
            )
        }


    }
}