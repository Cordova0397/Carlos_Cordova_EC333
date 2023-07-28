package proyectos.moviles.carlos_cordova_ec3.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import proyectos.moviles.carlos_cordova_ec3.R
import proyectos.moviles.carlos_cordova_ec3.databinding.ActivityLogin2Binding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLogin2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogin2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tilEmail.editText?.addTextChangedListener(textWatcher)
        binding.tilPassword.editText?.addTextChangedListener(textWatcher)

        binding.btnlogin.isEnabled = false // Deshabilitar el botón al inicio

        binding.btnlogin.setOnClickListener {
            val email = binding.tilEmail.editText?.text.toString()
            val password = binding.tilPassword.editText?.text.toString()

            if (validedEmailPass(email, password)) {
                val validateEmail = "ejemplo@idat.edu.pe"
                val validatePass = "123456"

                if (email == validateEmail && password == validatePass) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // Mostrar mensaje de error cuando las credenciales son válidas, pero no coinciden con los valores establecidos.
                    binding.tilEmail.error = "Credenciales incorrectas"
                    binding.tilPassword.error = "Credenciales incorrectas"
                }
            } else {
                // Mostrar mensaje de error cuando las credenciales ingresadas no son válidas.
                binding.tilEmail.error = "Ingrese un correo válido"
                binding.tilPassword.error = "La contraseña debe tener al menos 6 caracteres"
            }
        }
    }

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            val email = binding.tilEmail.editText?.text.toString()
            val password = binding.tilPassword.editText?.text.toString()
            val isValid = validedEmailPass(email, password)

            binding.btnlogin.isEnabled = isValid

            // Limpiar mensajes de error cuando los campos se actualizan.
            binding.tilEmail.error = null
            binding.tilPassword.error = null
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    }

    private fun validedEmailPass(email: String, pass: String): Boolean {
        val validateEmail = email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
        val validatePass = pass.length >= 6
        return validateEmail && validatePass
    }
}