package com.rsschool.android2021

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class FirstFragment : Fragment() {


    private var generateButton: Button? = null
    private var previousResult: TextView? = null
    private var secondOpen: OpenSecondFragmentSup?=null
    private var min: EditText? = null
    private var max: EditText? = null


    override fun onAttach(context: Context) {
        super.onAttach(context)
         secondOpen = context as OpenSecondFragmentSup;
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        previousResult = view.findViewById(R.id.previous_result)
        generateButton = view.findViewById(R.id.generate)

        val result = arguments?.getInt(PREVIOUS_RESULT_KEY)
        previousResult?.text = "Previous result: ${result.toString()}"
        min = view.findViewById(R.id.min_value);
        max = view.findViewById(R.id.max_value);


        // TODO: val min = ...
        // TODO: val max = ...


        generateButton?.setOnClickListener {
            secondOpen?.anywayOpenSecondFragment(min?.text.toString().toInt(),max?.text.toString().toInt())

            // TODO: send min and max to the SecondFragment
        }

    }




    companion object {

        @JvmStatic
        fun newInstance(previousResult: Int): FirstFragment {
            val fragment = FirstFragment()
            val args = Bundle()
            args.putInt(PREVIOUS_RESULT_KEY, previousResult)
            fragment.arguments = args
            return fragment
        }

        private const val PREVIOUS_RESULT_KEY = "PREVIOUS_RESULT"
    }
}