package com.example.homework181_dialogs




import android.annotation.SuppressLint




import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*



import kotlinx.android.synthetic.main.activity_main.*
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.TimePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_dialog.view.*
import kotlinx.android.synthetic.main.item_shiled_dialog.*
import kotlinx.android.synthetic.main.itm_fragment.view.*
import java.lang.reflect.Array.newInstance
import java.net.URLClassLoader.newInstance
import javax.xml.transform.TransformerFactory.newInstance

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

   txt1.setOnClickListener {

       val dialog = AlertDialog.Builder(this)

       dialog.setTitle("Alert dialog title")
       // dialog.setMessage("Message alert dialog")
       dialog.setCancelable(false)

       dialog.setPositiveButton("Positive", object : DialogInterface.OnClickListener {
           override fun onClick(dialog: DialogInterface?, which: Int) {
               Toast.makeText(this@MainActivity, "Positive clickded", Toast.LENGTH_SHORT).show()
           }
       })

       dialog.setNegativeButton("Negative ", object : DialogInterface.OnClickListener {
           override fun onClick(dialog: DialogInterface?, which: Int) {
               dialog?.dismiss()
           }
       })

       dialog.setNeutralButton("Neutral ", object : DialogInterface.OnClickListener {
           override fun onClick(dialog: DialogInterface?, which: Int) {

           }
       })
       dialog.show()
   }

        txt2.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this)
            val dialog = alertDialog.create()

            dialog.setTitle(" Custom dialog")
            val dialogView = layoutInflater.inflate(R.layout.custom_dialog, null, false)
            dialog.setView(dialogView)

            dialogView.btn_close.setOnClickListener {
                Toast.makeText(this, "${dialogView.edt_email_dialog.text}\n ${dialogView.edt_password_dialog.text}+ saved", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }

            dialog.show()

        }
        txt3.setOnClickListener {

            val myDialogFragment = MyDialogFragment.newInstance("First", "Second")
            myDialogFragment.show(supportFragmentManager.beginTransaction(), "keys")

        }
        txt4.setOnClickListener {
            val datePickerDialog = DatePickerDialog(this)

            datePickerDialog.setOnDateSetListener { view, year, month, dayOfMonth ->
                Toast.makeText(this, "${dayOfMonth}.${month+1}.$year", Toast.LENGTH_SHORT).show()
            }

            datePickerDialog.show()
        }
        txt5.setOnClickListener {

            val timePickerDialog = TimePickerDialog(
                this,
                object : TimePickerDialog.OnTimeSetListener {
                    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                        Toast.makeText(this@MainActivity, "$hourOfDay:$minute", Toast.LENGTH_SHORT).show()
                    }

                },
                24,
                60,
                true
            )
            timePickerDialog.updateTime(12, 50)
            timePickerDialog.show()
        }
        txt6.setOnClickListener {
            val bottomSheetDialog = BottomSheetDialog(this)
            bottomSheetDialog.setCancelable(false)
            bottomSheetDialog.setContentView(layoutInflater.inflate(R.layout.item_shiled_dialog, null, false))
            bottomSheetDialog.show()
            bottomSheetDialog.bbn_cancel.setOnClickListener {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show()
                bottomSheetDialog.dismiss()
            }

        }

        txt7.setOnClickListener {
            val snackbar = Snackbar.make(it, "Salom snackbar", Snackbar.LENGTH_LONG)

            snackbar.setAction("Click", object : View.OnClickListener {
                override fun onClick(v: View?) {
                    Toast.makeText(this@MainActivity, "Click", Toast.LENGTH_SHORT).show()
                }
            })

            snackbar.show()

        }




    }
}