import android.annotation.SuppressLint
import android.app.Activity
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.juanperilla.ecommerceapp.R

@SuppressLint("InvalidColorHexValue")
@Composable
fun LoginScreen(navController: NavController) {
    // estado
    var inputEmail by remember { mutableStateOf("hola") }
    var inputPassword by remember { mutableStateOf("") }


    val activity = LocalView.current.content as Activity

    Scaffold { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.logounab),
                contentDescription = "Logo Unab",
                modifier = Modifier.size(150.dp)
            )
            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Iniciar sesión",
                fontSize = 24.sp,
                color = Color(0xFFFF9900),
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = inputEmail,
                onValueChange = { inputEmail = it },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email",
                        tint = Color(0xFFFF9900)
                    )
                },
                label = {
                    Text(text = "Correo Electrónico")
                },
                shape = RoundedCornerShape(12.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = inputPassword,
                onValueChange = { inputPassword = it },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Contraseña",
                        tint = Color(0xFFFF9900)
                    )
                },
                label = {
                    Text(text = "Contraseña")
                },
                shape = RoundedCornerShape(12.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val auth = Firebase.auth


                    auth.signInWithEmailithEmailAndPassword(inputEmail,inputPassword)
                        .addOnCompleteListener (activity){ task ->
                            if(task.isSuccessful){



                            }else{
                                Log.i("login", "hubo un error")

                            }

                        }

                    navController.navigate("home")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF9900)
                )
            ) {
                Text("Iniciar sesión")
            }
            Spacer(modifier = Modifier.height(16.dp))

            TextButton(onClick = {}) {
                Text(
                    text = "¿No tienes una cuenta? Regístrate",
                    color = Color(0xFFFF9900)
                )
            }
        }
    }
}

fun validateEmail(Email: String):Pair<Boolean, String>{
    return when {
        email.isempty() ->pair(false, "El correo es obligatorio")
        !email.endsWith("@unab.edu.co") -> Pair(false, "El correo debe ser unab. ")
        else -> Pair(true, "")

    }


}


