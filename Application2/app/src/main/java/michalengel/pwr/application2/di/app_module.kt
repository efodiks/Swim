package michalengel.pwr.application2.di

import michalengel.pwr.application2.data.ImagesDataSource
import michalengel.pwr.application2.view.viewmodels.ImagesViewModel
import org.koin.android.architecture.ext.viewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext



val groupModule: Module = applicationContext {
    viewModel { ImagesViewModel(androidApplication().contentResolver, get()) }
}