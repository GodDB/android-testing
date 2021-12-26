package com.example.android.architecture.blueprints.todoapp.data.source

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.architecture.blueprints.todoapp.data.Result
import com.example.android.architecture.blueprints.todoapp.data.Task
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DefaultTasksRepositoryTest {

    private lateinit var tasksRepository: DefaultTasksRepository

    private val task1 = Task("Title1", "Description1")
    private val task2 = Task("Title2", "Description2")
    private val task3 = Task("Title3", "Description3")
    private val remoteTasks = listOf(task1, task2).sortedBy { it.id }
    private val localTasks = listOf(task3).sortedBy { it.id }
    private val newTasks = listOf(task3).sortedBy { it.id }

    @Before
    fun before() {
        tasksRepository = DefaultTasksRepository(FakeTasksRemoteDataSource(remoteTasks.toMutableList()), FakeTasksLocalDataSource(localTasks.toMutableList()), Dispatchers.Unconfined)
    }

    @Test
    fun 전체_Task를_가져온다() = runBlocking {
        //given

        //when
        val task = tasksRepository.getTasks(true) as Result.Success

        //then
        assertEquals(task.data, remoteTasks)
    }





}