package GameTest;

import org.lwjgl.Version;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL14;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Display{
	
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
	
	
	//That function that holds everything together
	private void gameLoop() {
		
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, 800, 0, 600, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		
		//the game that's running
		while(!glfwWindowShouldClose(window)) {
			//input();
			//update();
			//render();
//	        glBegin(GL_TRIANGLES);
//	        glColor3f(1f, 0f, 0f);
//	        glVertex3f(-0.6f, -0.4f, 0f);
//	        glColor3f(0f, 1f, 0f);
//	        glVertex3f(0.6f, -0.4f, 0f);
//	        glColor3f(0f, 0f, 1f);
//	        glVertex3f(0f, 0.6f, 0f);
//	        glEnd();
			
			// Clear the screen and depth buffer
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);  
			         
			// set the color of the quad (R,G,B,A)
			GL11.glColor3f(0.5f,0.5f,1.0f);
			     
			// draw quad
			GL11.glBegin(GL11.GL_QUADS);
			    GL11.glVertex2f(100,100);
			    GL11.glVertex2f(100+200,100);
			    GL11.glVertex2f(100+200,100+200);
			    GL11.glVertex2f(100,100+200);
			GL11.glEnd();
			glfwSwapBuffers(window);
			glfwPollEvents();
		}
	}
	
	public void gameStart() {
		init();
		System.out.println("LWJGL Version " + Version.getVersion() + " is working.");
		gameLoop();
		
		
		//kills the 
		glfwDestroyWindow(window);
//		keyCallback.free();
	}

}
