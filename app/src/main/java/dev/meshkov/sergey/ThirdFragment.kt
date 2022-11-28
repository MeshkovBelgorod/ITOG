package dev.meshkov.sergey

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class ThirdFragment : Fragment() {
    private lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //инициализируем переменные
        button = view.findViewById(R.id.button)
        //при нажатии на кнопку открываем ссылку
        button.setOnClickListener(View.OnClickListener { view2 ->
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com/id433034727"))
            requireActivity().startActivity(browserIntent)
        })

    }
}