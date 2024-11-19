package com.example.bookmark

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookmark.retrofit.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up the RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Fetch data from API
        fetchCharacterData { characterList ->
            // Set the data to RecyclerView adapter
            recyclerView.adapter = CharacterAdapter(characterList)
        }
    }

    // Function to fetch character data using Retrofit
    private fun fetchCharacterData(callback: (List<MainModel>) -> Unit) {
        lifecycleScope.launch {
            try {
                // Make the API call using the ApiService
                val response = ApiService.endpoint.getCharacter()

                // Check if response is successful and contains data
                if (response.data != null) {
                    callback(response.data) // Pass data to the callback
                } else {
                    // Handle the case when the response is empty or null
                    Toast.makeText(this@MainActivity, "No data available", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                // Handle any exceptions or errors
                Toast.makeText(this@MainActivity, "Error: ${e.localizedMessage}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
