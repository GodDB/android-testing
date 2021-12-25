package com.example.android.architecture.blueprints.todoapp.tasks

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.architecture.blueprints.todoapp.test.getOrAwaitValue
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TasksViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Test
    fun 새로운_태스크가_추가되었을때_뷰모델_상태검증() {
        //given
        val viewModel = TasksViewModel(ApplicationProvider.getApplicationContext())

        //when
        viewModel.addNewTask()

        //then
        val value = viewModel.newTaskEvent.getOrAwaitValue()
        assertNotEquals(value.getContentIfNotHandled(), null)
    }

}