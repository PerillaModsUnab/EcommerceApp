import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.juanperilla.ecommerceapp.R

@SuppressLint("InvalidColorHexValue")
@Composable
fun LoginScreen() {
    Scaffold { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.logounab),
                contentDescription = "Logo Unab",
                modifier = Modifier.size(150.dp)
            )
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "Iniciar sesión",
                fontSize = 24.sp, // Corrected fontSize instead of fontsize
                color = Color(0xFFFF9900), // Fixed color hex value
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp)) // Added space between title and input field

            // OutlinedTextField
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email",
                        tint = Color(0xFFF9900)
                    )
                },
                label = {
                    Text(text = "Correo Electrónico")
                },
                shape = RoundedCornerShape(12.dp)
            )
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}

