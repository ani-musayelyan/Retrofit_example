package JsonExample

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.R
import dmax.dialog.SpotsDialog
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class JsonActivity : AppCompatActivity() {

    lateinit var dialog: AlertDialog
    lateinit var apiInterface : Call<MutableList<Photo>>
    lateinit var jlayoutManager: LinearLayoutManager
    private lateinit var json_rcView : RecyclerView
    private lateinit var adapter: JsonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_json)

        jlayoutManager = LinearLayoutManager(this)

        json_rcView = findViewById(R.id.json_rcView)
        json_rcView.setHasFixedSize(true)
        json_rcView.layoutManager = jlayoutManager
        adapter = JsonAdapter(this)
        json_rcView.adapter = adapter

        dialog = SpotsDialog.Builder().setCancelable(true).setContext(this).build()

        jsonGetter()

    }


    fun jsonGetter() {
        dialog.show()
        apiInterface = ApiInterface.create().getJson()
        apiInterface.enqueue(object : Callback<MutableList<Photo>> {
            override fun onResponse(
                call: Call<MutableList<Photo>>?,
                response: Response<MutableList<Photo>>?
            ) {
                if (response?.body() != null) {
                    Toast.makeText(baseContext, "${response.body().size}", Toast.LENGTH_LONG).show()
                    adapter.jsonList = response.body()
                    adapter.notifyDataSetChanged()
                }
                dialog.dismiss()
            }

            override fun onFailure(call: Call<MutableList<Photo>>?, t: Throwable?) {
                Toast.makeText(baseContext, "Nothing to show", Toast.LENGTH_LONG).show()
                dialog.dismiss()
            }
        })

}


}