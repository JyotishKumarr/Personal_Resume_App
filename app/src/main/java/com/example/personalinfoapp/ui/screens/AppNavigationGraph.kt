package com.example.personalinfoapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.personalinfoapp.UserInputViewModel

@Composable
fun AppNavigationGraph(userInputViewModel: UserInputViewModel = viewModel()) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.USER_SCREEN) {
        composable(Routes.USER_SCREEN) {
            val route = when (userInputViewModel.uiState.value.profileSelected) {
                "Personal details" -> Routes.PERSONAL_DETAILS
                "Educational Details" -> Routes.EDUCATIONAL_DETAILS
                "Professional work" -> Routes.PROFESSIONAL_WORK
                "Location" -> Routes.LOCATION
                else -> Routes.PERSONAL_DETAILS // Default to PERSONAL_DETAILS if none of the above matches
            }

            UserScreen(userInputViewModel, showScreen = { navController.navigate(route + "/${it.first}/${it.second}") })
        }

        composable(
            "${Routes.PERSONAL_DETAILS}/{${Routes.USER_NAME}}/{${Routes.PROFILE_SELECTED}}",
            arguments = listOf(
                navArgument(name = Routes.USER_NAME) { type = NavType.StringType },
                navArgument(name = Routes.PROFILE_SELECTED) { type = NavType.StringType }
            )
        ) {
            val username = it?.arguments?.getString(Routes.USER_NAME)
            val profileselected = it?.arguments?.getString(Routes.PROFILE_SELECTED)
            PersonalScreen(username, profileselected)
        }

        composable(
            "${Routes.EDUCATIONAL_DETAILS}/{${Routes.USER_NAME}}/{${Routes.PROFILE_SELECTED}}",
            arguments = listOf(
                navArgument(name = Routes.USER_NAME) { type = NavType.StringType },
                navArgument(name = Routes.PROFILE_SELECTED) { type = NavType.StringType }
            )
        ) {
            val username = it?.arguments?.getString(Routes.USER_NAME)
            val profileselected = it?.arguments?.getString(Routes.PROFILE_SELECTED)
            EducationScreen(username, profileselected)
        }

        composable(
            "${Routes.PROFESSIONAL_WORK}/{${Routes.USER_NAME}}/{${Routes.PROFILE_SELECTED}}",
            arguments = listOf(
                navArgument(name = Routes.USER_NAME) { type = NavType.StringType },
                navArgument(name = Routes.PROFILE_SELECTED) { type = NavType.StringType }
            )
        ) {
            val username = it?.arguments?.getString(Routes.USER_NAME)
            val profileselected = it?.arguments?.getString(Routes.PROFILE_SELECTED)
            ProfessionalScreen(username, profileselected)
        }

        composable(
            "${Routes.LOCATION}/{${Routes.USER_NAME}}/{${Routes.PROFILE_SELECTED}}",
            arguments = listOf(
                navArgument(name = Routes.USER_NAME) { type = NavType.StringType },
                navArgument(name = Routes.PROFILE_SELECTED) { type = NavType.StringType }
            )
        ) {
            val username = it?.arguments?.getString(Routes.USER_NAME)
            val profileselected = it?.arguments?.getString(Routes.PROFILE_SELECTED)
            LocationScreen(username, profileselected)
        }
    }
}
