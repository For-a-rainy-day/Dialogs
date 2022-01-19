package com.example.homework181_dialogs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_dialog.view.*
import kotlinx.android.synthetic.main.fragment_my_dialog.view.*


class MyDialogFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null



    lateinit var root:View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        root =  inflater.inflate(R.layout.fragment_my_dialog, container, false)

        root.txt_2.text = "Fragment Dialog"
        root.txt_1.text = "Fragment Dialogs"


        root.btn_1.setOnClickListener {
            fragmentManager?.beginTransaction()?.remove(this)?.commit()

            Toast.makeText(context, "Done", Toast.LENGTH_SHORT).show()

        }

        root.btn_2.setOnClickListener {
            fragmentManager?.beginTransaction()?.remove(this)?.commit()
            Toast.makeText(context, "Canceled", Toast.LENGTH_SHORT).show()
        }


        return root
    }
    }


