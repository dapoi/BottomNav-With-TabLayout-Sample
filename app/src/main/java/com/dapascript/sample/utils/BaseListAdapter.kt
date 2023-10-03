package com.dapascript.sample.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

class BaseListAdapter<T : Any>(
    private val inflate: (layoutInflater: LayoutInflater, parent: ViewGroup?, attachToParent: Boolean) -> ViewBinding,
    private val bind: (item: T, binding: ViewBinding) -> Unit,
    compareItems: (old: T, new: T) -> Boolean,
    compareContents: (old: T, new: T) -> Boolean
) : ListAdapter<T, RecyclerView.ViewHolder>(DiffCallback(compareItems, compareContents)) {

    private var items = emptyList<T>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ItemViewHolder(inflate(LayoutInflater.from(parent.context), parent, false))

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        bind(getItem(position), (holder as BaseListAdapter<T>.ItemViewHolder).binding)
    }

    internal fun setItems(items: List<T>, function: () -> Unit) {
        this.items = items
        this.submitList(items) {
            function()
        }
    }

    inner class ItemViewHolder(val binding: ViewBinding) : RecyclerView.ViewHolder((binding).root) {
    }

    private class DiffCallback<K : Any>(
        private val compareItems: (old: K, new: K) -> Boolean,
        private val compareContents: (old: K, new: K) -> Boolean
    ) : DiffUtil.ItemCallback<K>() {
        override fun areItemsTheSame(old: K, new: K) = compareItems(old, new)
        override fun areContentsTheSame(old: K, new: K) = compareContents(old, new)
    }
}