package com.aaacapital.personalchat.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

interface BaseState
interface BaseEvent
interface BaseEffect

abstract class BaseViewModel<S : BaseState, V : BaseEvent, F : BaseEffect> : ViewModel() {
    abstract fun setInitialState(): S
    private val initialState: S by lazy { setInitialState() }
    abstract fun handleEvent(event: V)

    private val _uiState = MutableStateFlow(initialState)
    val uiState = _uiState.asStateFlow()

    private val _effect = MutableSharedFlow<F>()
    val effect = _effect.asSharedFlow()

    protected fun setState(currentState: S.() -> S) {
        _uiState.value = currentState.invoke(uiState.value)
    }

    protected fun setEffect(effect: () -> F) = viewModelScope.launch {
        _effect.emit(effect.invoke())
    }

    open fun sendEvent(event: V) = handleEvent(event)

}
