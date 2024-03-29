package com.hans.exercise.session01


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hans.exercise.session01.model.ProductEntity
import kotlinx.android.synthetic.main.fragment_detail_product.*

/**
 * A simple [Fragment] subclass.
 */
class DetailProductFragment : Fragment() {

    private var listener: OnProductListener? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_product, container, false)
    }


    fun renderProduct(productEntity: ProductEntity) {
        val name = productEntity.name
        val description = productEntity.description
        val price = "S/ ".plus(productEntity.price)

        tviName.text = name
        tviDescription.text = description
        tviPrice.text = price
        iviProduct.setImageResource(productEntity.photo)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnProductListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnContactListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}
