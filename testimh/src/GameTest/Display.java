package GameTest;

import org.lwjgl.Version;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.opengl.GL;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Display {
	
	private int width, height;
	private String title;
	private long window;

	//error call back
	private static GLFWErrorCallback errCallback = GLFWErrorCallback.createPrint(System.err);
	//key call back
	
	private static GLFWKeyCallback keyCallback = new GLFWKeyCallback() {
		@Override
		public void invoke(long window, int key, int scancode, int action, int mods) {
			if(key == GLFW_KEY_ESCAPE && action == GLFW_PRESS) {
				glfwSetWindowShouldClose(window, true);
			}
		}
	};

	
	public Display(int width, int height, String title) {
		// TODO Auto-generated constructor stub
		//referring variables to its own object rather than elsewhere.
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	
	private void init() {
		System.out.println("Starting...");
		glfwSetErrorCallback(errCallback);
		
		if(!glfwInit()) {
			throw new IllegalStateException("Unable to initialize");
		}
		
		//This creates the screen
		window = glfwCreateWindow(width,height, title, NULL, NULL);
		if(window == NULL) {
			glfwTerminate();
			throw new RuntimeException("Failed to create window");
		}
		
		//Exit key ESC is set (optional not really needed..)
//		glfwSetKeyCallback(window, keyCallback);
		
		glfwMakeContextCurrent(window);
		GL.createCapabilities();
		
	}
	
	private void gameLoop() {
		
		//the game that's running
		while(!glfwWindowShouldClose(window)) {
			
			//input()
			//update()
			//render()
			
			
            glBegin(GL_TRIANGLES);
            glColor3f(1f, 0f, 0f);
            glVertex3f(-0.6f, -0.4f, 0f);
            glColor3f(0f, 1f, 0f);
            glVertex3f(0.6f, -0.4f, 0f);
            glColor3f(0f, 0f, 1f);
            glVertex3f(0f, 0.6f, 0f);
            glEnd();
			
			glfwSwapBuffers(window);
			glfwPollEvents();
		}
	}
	
	public void gameStart() {
		init();
		System.out.println("LWJGL Version " + Version.getVersion() + " is working.");
		gameLoop();
		
		glfwDestroyWindow(window);
		keyCallback.free();
	}

}
