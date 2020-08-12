package com.paulsoia.multilistadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

//это расширение для класса ViewGroup. Теперь мы можем по всему проекту использовать
//короткое inflate вместо длинного LayoutInflater.from(context).inflate
fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View =
    LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)