package dev.meshkov.sergey

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SecondFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recycleView)
        button = view.findViewById(R.id.button)
        var list = mutableListOf<ModelRV>() //список куда будут класться элементы для RecycleView
        list.add(
            ModelRV(
                path = "https://www.gas-nn.ru/pay",
                name = "ГАЗ"
            )
        )
        list.add(
            ModelRV(
                path = "https://click.email4customers.com/WebVersion?messageId=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6NTI4MzU2NjUyNjM0OTAxNjE3fQ.GlH5IMSnaQ4cl5yaqBsn7fYH-afyuWO-tfwuEC0nlR4",
                name = "Электроэнергия"
            )
        )

        list.add(
            ModelRV(
                path = "https://login.mos.ru/sps/login/methods/password?bo=%2Fsps%2Foauth%2Fae%3Fscope%3Dprofile%2Bopenid%2Bcontacts%2Busr_grps%26response_type%3Dcode%26redirect_uri%3Dhttps%3A%2F%2Fwww.mos.ru%2Fapi%2Facs%2Fv1%2Flogin%2Fsatisfy%26client_id%3Dmos.ru",
                name = "Вода"
            )
        )
        recyclerView.layoutManager = LinearLayoutManager(context)
        //присваем адаптер к  recyclerview
        recyclerView.adapter = Adapter(context = requireContext(), list, this)
        //при нажатии на кнопку накладываем на второй фрагмент ThirdFragment
        button.setOnClickListener(View.OnClickListener { view2 ->
            val transaction = parentFragmentManager.beginTransaction()
            transaction.addToBackStack("")
            transaction.add(R.id.container, ThirdFragment())
            transaction.commit()
        })
    }

}