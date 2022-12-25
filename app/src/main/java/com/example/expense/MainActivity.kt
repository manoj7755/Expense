package com.example.expense

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.expense.Adapter.CaegoryItemAdapter
import com.example.expense.Adapter.MainRecycleViewAdapter
import com.example.expense.Database.DatabaseModel
import com.example.expense.Database.ExpenseDatabase
import com.example.expense.ModelClass.CategoryModel
import com.example.expense.ModelClass.ModelOfItemRow
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_dialog.*
import kotlinx.android.synthetic.main.category_add_item.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope

class MainActivity : AppCompatActivity() {
    lateinit var MyDb: ExpenseDatabase
    lateinit var mainViewsModel: mainViewsModel
    var Damt = ""
    var Dtitle = ""
    var Ddisc = ""
    var Dtrst = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MyDb = ExpenseDatabase.getDatabase(this)
        val expoRepository = expoRepository(MyDb.DaoModel())
        mainViewsModel = ViewModelProvider(this,mianActivityViewModelFactory(expoRepository))[mainViewsModel::class.java]


        val arrayData = ArrayList<ModelOfItemRow>().apply {
            add(ModelOfItemRow(R.drawable.shoes, "Shoes1", "Nike", "500", "500"))
            add(ModelOfItemRow(R.drawable.shoes, "Shoes2", "Nike", "500", "500"))
            add(ModelOfItemRow(R.drawable.shoes, "Shoes3", "Nike", "500", "500"))
            add(ModelOfItemRow(R.drawable.shoes, "Shoes4", "Nike", "500", "500"))
        }
        recycleView.adapter = MainRecycleViewAdapter(this, arrayData)
        recycleView.layoutManager = LinearLayoutManager(this)

        add_btn.setOnClickListener {
            val addDialog = Dialog(this)
            addDialog.setContentView(R.layout.add_dialog)
            addDialog.setCancelable(false)
            Damt = addDialog.AD_amt.text.toString()
            Dtitle = addDialog.Ad_title.text.toString()
            Ddisc = addDialog.AD_desc.text.toString()


            val sData = arrayOf("Debit", "Credit")
            val arrayadapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, sData)
            addDialog.spinner.adapter = arrayadapter

            addDialog.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                    Toast.makeText(this@MainActivity, "${p2}", Toast.LENGTH_SHORT).show()
                    Dtrst = p2.toString()

                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }

            }


            addDialog.title_img.setOnClickListener {
                val titleImgDialog = Dialog(this)
                titleImgDialog.setContentView(R.layout.category_add_item)
                val arrdata = ArrayList<CategoryModel>().apply {
                    add(CategoryModel(R.drawable.shoes, "Patna1"))
                    add(CategoryModel(R.drawable.shoes, "Patna2"))
                    add(CategoryModel(R.drawable.shoes, "Patna3"))
                    add(CategoryModel(R.drawable.shoes, "Patna4"))
                    add(CategoryModel(R.drawable.shoes, "Patna5"))
                    add(CategoryModel(R.drawable.shoes, "Patna6"))
                    add(CategoryModel(R.drawable.shoes, "Patna7"))
                    add(CategoryModel(R.drawable.shoes, "Patna8"))
                    add(CategoryModel(R.drawable.shoes, "Patna9"))
                }
                titleImgDialog.recycleView_categoryItem.adapter = CaegoryItemAdapter(this, arrdata)
                titleImgDialog.recycleView_categoryItem.layoutManager = GridLayoutManager(this, 3)

                titleImgDialog.show()
            }
            addDialog.ad_btn.setOnClickListener {
                addDataInDataBase(0,"Manoj",Dtitle,Ddisc,"shoes",Damt,Dtrst)
                addDialog.dismiss()
            }
            addDialog.show()
        }


    }

    fun addDataInDataBase(
        id: Int,
        UserName: String,
        title: String,
        disc: String,
        type: String,
        amt: String,
        TrnsTyp: String
    ) {
        mainViewsModel.addData(
            DatabaseModel(
                id,
                UserName,
               title,
                disc,
                type,
                amt.toDouble(),
                TrnsTyp,
                "21/11/22"
            )
        )
    }

}
