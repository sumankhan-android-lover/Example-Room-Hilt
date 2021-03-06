package com.frndzcode.client.example_room_hilt.utils.custom

import android.view.View
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar


/**
 * Loads URL into an ImageView using Glide
 *
 * @param action string
 * @sample fab.setOnClickListener {
 *       it.snack("Snack message") {
 *       action("Action") { toast("Action clicked") }
 *       }
 *   }
 */

inline fun View.snack(@StringRes messageRes: Int, length: Int = Snackbar.LENGTH_LONG, f: Snackbar.() -> Unit) {
    snack(resources.getString(messageRes), length, f)
}

inline fun View.snack(message: String, length: Int = Snackbar.LENGTH_LONG, f: Snackbar.() -> Unit) {
    val snack = Snackbar.make(this, message, length)
    snack.f()
    snack.show()
}

fun Snackbar.action(@StringRes actionRes: Int, color: Int? = null, listener: (View) -> Unit) {
    action(view.resources.getString(actionRes), color, listener)
}

fun Snackbar.action(action: String, color: Int? = null, listener: (View) -> Unit) {
    setAction(action, listener)
    color?.let { setActionTextColor(ContextCompat.getColor(context, color)) }
}