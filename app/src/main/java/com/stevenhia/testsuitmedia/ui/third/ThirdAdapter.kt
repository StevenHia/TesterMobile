package com.stevenhia.testsuitmedia.ui.third

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stevenhia.testsuitmedia.R
import com.stevenhia.testsuitmedia.databinding.ItemUserBinding
import com.stevenhia.testsuitmedia.model.UserModel
import com.stevenhia.testsuitmedia.ui.second.SecondActivity

class ThirdAdapter : RecyclerView.Adapter<ThirdAdapter.ViewHolder>() {
    private var listUser = ArrayList<UserModel>()

    /* fun setData(items: List<UserModel>) {
         val diffCallback = UserDiffCallback(this.listUser, items)
         val diffResult = DiffUtil.calculateDiff(diffCallback)
         this.listUser.clear()
         this.listUser.addAll(items)
         diffResult.dispatchUpdatesTo(this)
     }*/

    class ViewHolder(private var binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: UserModel) {
            binding.tvFullName.text =
                itemView.context.getString(R.string.fullName, data.first_name, data.last_name)
            binding.tvEmail.text = data.email

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, SecondActivity::class.java)
                intent.putExtra(SecondActivity.INTENT_DATA, data)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listUser[position])
    }

    override fun getItemCount(): Int = listUser.size


}