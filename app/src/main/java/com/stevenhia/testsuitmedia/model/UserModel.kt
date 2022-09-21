package com.stevenhia.testsuitmedia.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserModel(
    var id: Int? = 0,
    var first_name: String? = null,
    var last_name: String? = null,
    var email: String? = null,
    var image: Int? = 0
) : Parcelable
