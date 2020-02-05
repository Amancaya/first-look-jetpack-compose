package negron.kaya.firstjetpackcompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.*
import androidx.ui.engine.geometry.Offset
import androidx.ui.graphics.Color
import androidx.ui.graphics.Shadow
import androidx.ui.layout.Column
import androidx.ui.layout.ExpandedHeight
import androidx.ui.layout.Spacing
import androidx.ui.material.*
import androidx.ui.material.surface.Surface
import androidx.ui.text.TextStyle
import androidx.ui.text.font.Font
import androidx.ui.text.font.FontFamily
import androidx.ui.text.font.FontStyle
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {
                MyScreenContent()
            }
        }
    }
}

@Composable
fun MyApp(children: @Composable() () -> Unit) {
    MaterialTheme {
        Surface(color = Color.Yellow) {
            children()
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text (text = "Hello $name!",
//            style = TextStyle(
//                    color = Color.Blue, fontSize = TextUnit(12),
//                    shadow = Shadow(
//                            color = Color.Green,
//                            blurRadius = 4.px,
//                            offset = Offset(3f, 5f)
//                    )
//            ),
            style = (+MaterialTheme.typography()).h1,

            modifier = Spacing( top = 16.dp, bottom = 16.dp, right = 4.dp, left = 4.dp )
    )
}

@Preview
@Composable
fun DefaultPreview() {
    MyAppTheme {
        MyScreenContent()
    }
}

@Composable
fun MyScreenContent(names: List<String> = listOf("Android", "there"), counterState: CounterState = CounterState()) {
    Column(modifier = ExpandedHeight) {
        Surface(modifier = Flexible(1f)) {
            Column(modifier = Flexible(1f)) {

                for (name in names) {
                    Greeting(name = name)
                    Divider(color = Color.Black)
                }
            }
        }
//        Greeting("Android")
//        Divider(color = Color.Black)
//        Greeting("there")

        Divider(color = Color.Transparent, height = 32.dp)
        Counter(counterState)

        Divider(color = Color.Transparent, height = 32.dp)
        Form(formState = FormState(true))
    }
}

@Composable
fun Counter(state: CounterState) {
    Button(
            text = "I've been clicked ${state.count} times",
            onClick = {
                state.count++
            },
            style = ContainedButtonStyle(color = if (state.count > 5) Color.Green else Color.White)
    )
}

@Composable
fun Form(formState: FormState) {
    Checkbox(
            checked = formState.optionChecked,
            onCheckedChange = { newState -> formState.optionChecked = newState })
}

//My Theme
@Composable
fun MyAppTheme(children: @Composable() () -> Unit) {
    MaterialTheme(colors = themeColors) {
        children()
    }
}

val green = Color(0xFF1EB980)
private val themeColors = ColorPalette(
        primary = green,
        surface = Color.DarkGray,
        onSurface = green
)