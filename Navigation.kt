package com.example.finalprojectyl


import ForumScreen
import HomeScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.finalprojectyl.login.LoginScreen
import com.example.finalprojectyl.signup.PolicyScreen
import com.example.finalprojectyl.signup.PrivacyScreen
import com.example.finalprojectyl.signup.SignupScreen
import com.example.finalprojectyl.ui.theme.YogaTimer


sealed class Route{
 data class LoginScreen(val name:String = "Login"):Route()
 data class SignupScreen(val name:String = "Signup"):Route()
 data class PrivacyScreen(val name:String = "PrivacyScreen"):Route()
 data class PolicyScreen(val name:String = "PolicyScreen"):Route()
 data class HomeScreen(val name:String = "Home"):Route()
 data class YogaTimer(val name:String = "YogaTimer"):Route()
 data class ForumScreen(val name:String = "forumScreen"):Route()

}

@Composable
fun MyNavigation(navHostController: NavHostController) {
 NavHost(
  navController = navHostController,
  startDestination = Route.LoginScreen().name,
 ) {

  composable(route = Route.LoginScreen().name) {
   LoginScreen(onLoginClick = {
    navHostController.navigate(
     Route.HomeScreen().name
    ) {
     popUpTo(route = "login_flow")
    }
   },
    onSignUpClick = {
     navHostController.navigateToSingleTop(
      Route.SignupScreen().name
     )
    }
   )
  }
  composable(route = Route.SignupScreen().name) {
   SignupScreen(
    onSignUpClick = {
     navHostController.navigateToSingleTop(
      Route.HomeScreen().name
     )
    },
    onLoginClick = {
     navHostController.navigateToSingleTop(
      Route.LoginScreen().name
     )
    },
    onPolicyClick = {
     navHostController.navigate(
      Route.PolicyScreen().name
     ) {
      launchSingleTop = true
     }
    },
    onPrivacyClick = {
     navHostController.navigate(
      Route.PrivacyScreen().name
     ) {
      launchSingleTop = true
     }
    }
   )
  }
  composable(route = Route.PrivacyScreen().name) {
   PrivacyScreen {
    navHostController.navigateUp()
   }
  }
  composable(route = Route.PolicyScreen().name) {
   PolicyScreen {
    navHostController.navigateUp()
   }
  }

  composable(route = Route.HomeScreen().name) {
   HomeScreen(
    onYogaTimerClick = {
     navHostController.navigate(
      Route.YogaTimer().name
     )
    },
    onForumScreenClick = {
     navHostController.navigate(
      Route.ForumScreen().name
     )
    })

  }
composable(route = Route.YogaTimer().name){
 YogaTimer(
   onReturnClick = {
   navHostController.navigate(
    Route.HomeScreen().name
   )

  }
 )
}
  composable(route = Route.ForumScreen().name){
   ForumScreen(
    onReturnHomeClick = {
     navHostController.navigate(
      Route.HomeScreen().name
     )
    }
   )
  }
 }
}



fun NavController.navigateToSingleTop(route:String){
 navigate(route){
  popUpTo(graph.findStartDestination().id){
   saveState =true
  }
  launchSingleTop = true
  restoreState = true
 }
}