# Page Navigation Demo
A proof of concept demonstration of an idea for a Jetpack Compose navigation library allowing the nesting of navigation destinations within the UI tree. This makes it possible to share common UI elememnts between screens (such as a navigation bar). This is an extrememely simplified implementation with no back stack, back handling, nav arguments, restoring state, etc., although I imagine these could be added by someone more familiar with Compose than I. I wanted to make this demo as I am unaware of any navigation libraries that work like this. I am interested to know your thoughts on this concept!

### Defining Pages
As seen in the demonstration, all navigation takes place within a PageNavigationRoot() composable. Within PageNavigationRoot(), PageSwitcher() can be called. Think of PageSwitcher like a NavHost()—basically a box whose content can switch between different screens. Inside PageSwitcher, a DefineNewPagesScope is provided allowing you to define new pages with calls to page. Like NavHost(), strings are used as navigation routes. However, unlike NavHost, PageSwitcher() calls can be nested inside of eachother and still be linked to the same navigation system, which happens automatically using CompositionLocal. By nesting PageSwitcher() calls, you can build a tree of navigation destinations.

Here's an example of how to define pages:
```
PageNavigationRoot(
    startingRoute = "TabsScreen/Tab1",
    transitionSpec = fullScreenTransition
) {
    PageSwitcher() {
        page("TabsScreen") {
            Column() {
                PageSwitcher() {
                    page("Tab1") {
                        // composable here
                    }
                    page("Tab2") {
                        // composable here
                    }
                }
                BottomNavigationBar()
            }
        }
        page("FullScreenPage") {
            // composable here
        }
    }
}
```
### Navigating
To navigate, retrieve a PageNavigator with rememberLocalPageNavigator(). PageNavigator gives you access to information about the current route and your current page, and allows you to navigate by calling navigateTo(). A sample call to navigate to might look like 'nav.navigateTo("TabsScreen/Tab1")', where "TabsScreen" will control the PageSwitcher() furthest up the tree and "Tab1" will controll the PageSwitcher() within the Tabs Screen. The a full path to a leaf node page must be specified, with page names saparated by forward slashes.

An example of navigation:
```
val nav = rememberLocalPageNavigator()

Button(onClick = { nav.navigateTo("TabsScreen/Tab2") }) {
  
}
```

An important thing to note is that PageSwitcher() and rememberLocalPageNavigator() can be called anywhere, but if they are not ultimately called from within a PageNavigationRoot() then an error will be thrown.

### Demonstration Video
Here's a video demo of this project, which showcases the advantages of Page Navigation to display a screen with multiple tabs sharing a navigation bar, and also display other fullscreen pages that don't share the navigation bar. I don't believe this can be implemented with NavHost(), or at least not without messy hacks.

https://github.com/coral134/PageNavigationDemo/assets/114889372/49894a5e-c25b-4a6a-9949-7463e38b8ded
