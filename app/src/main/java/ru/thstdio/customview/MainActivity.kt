package ru.thstdio.customview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import ru.thstdio.customview.navigation.NavCommand

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val command= NavCommand()
        command.init( Navigation.findNavController(this, R.id.nav_host_fragment))
    }
}
