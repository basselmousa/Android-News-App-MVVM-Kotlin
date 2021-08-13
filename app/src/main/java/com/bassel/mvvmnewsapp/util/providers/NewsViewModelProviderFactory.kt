package com.bassel.mvvmnewsapp.util.providers

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bassel.mvvmnewsapp.repository.NewsRepository
import com.bassel.mvvmnewsapp.viewmodel.NewsViewModel


/**
 * View Model Provider Factory  For Link The Repository With View Model
 */
@Suppress("UNCHECKED_CAST")
class NewsViewModelProviderFactory(
    val app: Application,
    private val newsRepository: NewsRepository
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(app, newsRepository) as T
    }

}