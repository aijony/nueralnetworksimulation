package graphics;
import static org.lwjgl.opengl.GL11.GL_FALSE;
import static org.lwjgl.opengl.GL20.*;

import utilities.FileUtility;

public class ShaderManager {

	private int programID;

	private int vertShader;
	private int fragShader;

	public ShaderManager() {
		// Create the shader program. If OK, create vertex and fragment shaders
		programID = glCreateProgram();
	}

	public void attachAndLinkShaders() {
		vertShader = loadAndCompileShader("res/vertex.vert", GL_VERTEX_SHADER);
		fragShader = loadAndCompileShader("res/fragment.frag", GL_FRAGMENT_SHADER);

		// Attach the compiled shaders to the program.
		glAttachShader(programID, vertShader);
		glAttachShader(programID, fragShader);
		glLinkProgram(programID);
	}

	private int loadAndCompileShader(String filepath, int shaderType) {
		// vertShader will be non zero if succefully created
		// Handle is used as a reference
		int shaderHandle = glCreateShader(shaderType);

		// Shader string
		String shaderCode = FileUtility.loadString(filepath);

		// Uploads shader to openGL
		glShaderSource(shaderHandle, shaderCode);

		// Compiles the shader
		glCompileShader(shaderHandle);

		// Check for errors
		if (glGetShaderi(shaderHandle, GL_COMPILE_STATUS) == GL_FALSE)
			throw new RuntimeException("Error creating vertex shader\n"
					+ glGetShaderInfoLog(shaderHandle, glGetShaderi(shaderHandle, GL_INFO_LOG_LENGTH)));

		return shaderHandle;
	}

	public void linkShader(boolean doLink) {

		if (doLink) {
			// Now link the program
			glUseProgram(programID);
		} else {
			// Un-bind our program
			glUseProgram(0);
		}
	}

	public void dispose() {

		// Detach the shaders
		glDetachShader(programID, vertShader);
		glDetachShader(programID, fragShader);

		// Delete the shaders
		glDeleteShader(vertShader);
		glDeleteShader(vertShader);

		// Delete the program
		glDeleteProgram(programID);
	}
}