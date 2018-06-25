package testimh;

import java.nio.IntBuffer;

import org.lwjgl.Version;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryUtil;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;

public class mymain {
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

	public static void main(String[] args) {
		System.out.println("LWJGL Version " + Version.getVersion() + " is working.");
		double time = glfwGetTime();
		long window;
		// TODO Auto-generated method stub
		glfwSetErrorCallback(errCallback);
		
		if(!glfwInit()) {
			throw new IllegalStateException("Unable to initialize");
		}
		
		window = glfwCreateWindow(800,600, "My test", NULL, NULL);
		if(window == NULL) {
			glfwTerminate();
			throw new RuntimeException("Failed to create window");
		}
		
		glfwSetKeyCallback(window, keyCallback);
		
		glfwMakeContextCurrent(window);
		GL.createCapabilities();
		
		while(!glfwWindowShouldClose(window)) {
			
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
		
		glfwDestroyWindow(window);
		keyCallback.free();
		
		
	}

}
