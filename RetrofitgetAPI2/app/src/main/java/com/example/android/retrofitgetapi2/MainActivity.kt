package com.example.android.retrofitgetapi2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    // call adapter and linearlayoutmanager
    lateinit var myAdapter: MyAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var viewModel: MyDataViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = MyDataViewModel()
        viewModel.liveData.observe(this, Observer {
            myAdapter = MyAdapter(baseContext, it)
            myAdapter.notifyDataSetChanged()
            recyclerview_users.adapter = myAdapter
        })
        // initialize adapter linearlayoutmanager
        recyclerview_users.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerview_users.layoutManager = linearLayoutManager

    }


//        // defining the get method
//        val retrofitBuilder = Retrofit.Builder()
//            .addConverterFactory(GsonConverterFactory.create())
//            .baseUrl(BASE_URL)
//            .build()
//            .create(ApiInterface::class.java)
//
//        //  data from interface
//        val retrofitData = retrofitBuilder.getData()
//
//        // add the enqueue (ctrl + shift + space)
//        retrofitData.enqueue(object : Callback<List<MyDataItem>?> {
//            override fun onResponse(
//                call: Call<List<MyDataItem>?>,
//                response: Response<List<MyDataItem>?>
//            ) {
//                val responseBody = response.body()!!
//
//                myAdapter = MyAdapter(baseContext, responseBody)
//                myAdapter.notifyDataSetChanged()
//                recyclerview_users.adapter = myAdapter
//
//
//
//                // this method will help show the data field in a textview
//                val myStringBuilder = StringBuilder()
//                for (myData in responseBody) {
//                    myStringBuilder.append(myData.body)
//                    myStringBuilder.append("\n")
//                }
//                // append data to textview
//                txtId.text = myStringBuilder
//            }
//
//            override fun onFailure(call: Call<List<MyDataItem>?>, t: Throwable) {
//                // add an error message if any
//                Log.d("MainActivity", "onFailure:"+t.message)
//            }
//        })
//    }
}