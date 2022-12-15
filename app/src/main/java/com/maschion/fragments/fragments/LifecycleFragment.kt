package com.maschion.fragments.fragments

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.maschion.fragments.R
import com.maschion.fragments.databinding.FragmentHomeBinding

class LifecycleFragment : Fragment() {

    private val TAG = "Teste"
    private lateinit var binding: FragmentHomeBinding

    //view foi criada
    //onCreate executa antes do onCreateView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i(TAG, "onCreate")
    }

    //cria a view ou passa pelo parametro que colocamos no Fragment(R.layout.fragment_lifecycle)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //antes do viewbinding o layout era inflado assim:
//       return inflater.inflate(R.layout.fragment_lifecycle, container, false)

        //com viewbinding
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    //depois que a view foi criada
    //a partir on onViewCreated minha view já está criada e posso altera-la
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //aqui posso alterar a view programaticamente, se necessário

        Log.i(TAG, "onViewCreated")

        //val textView = requireView().findViewById<TextView>(R.id.textView)
        //textView.text = "Passou pelo onViewCreated"

        binding.textView.text = "Passou pelo onViewCreated agora com viewbinding"

    }

    //quando a view restaurada
    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        Log.i(TAG, "onViewStateRestored")

    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop")
    }

    //diferente do onDestroy da Activity. Este é chamado quando a view do Fragment é destruída
    override fun onDestroyView() {
        super.onDestroyView()
        Log.i(TAG, "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy")
    }

    //nao entra no ciclo de vida mas é um método importante
    //só é chamada se for inflado via xml

//    override fun onInflate(context: Context, attrs: AttributeSet, savedInstanceState: Bundle?) {
//        super.onInflate(context, attrs, savedInstanceState)
//        Log.i(TAG, "onInflate ${attrs.attributeCount}")
//    }

}