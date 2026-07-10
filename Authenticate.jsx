import { useState } from "react";

function AuthenForm() {
  const [formData, setFormData] = useState({
    username: "",
    password: "",
  });

  const [errors, setErrors] = useState({});
  const [showPassword, setShowPassword] = useState(false);
  const [rememberMe, setRememberMe] = useState(false);

  const styles = {
    page: {
      minHeight: "100vh",
      display: "flex",
      justifyContent: "center",
      alignItems: "center",
      backgroundColor: "#f4f6f9",
      fontFamily: "Arial, sans-serif",
    },

    container: {
      width: "360px",
      backgroundColor: "#fff",
      padding: "30px",
      borderRadius: "12px",
      boxShadow: "0 6px 18px rgba(0,0,0,0.15)",
    },

    title: {
      textAlign: "center",
      color: "#333",
      marginBottom: "8px",
    },

    subtitle: {
      textAlign: "center",
      color: "#666",
      fontSize: "14px",
      marginBottom: "25px",
    },

    input: {
      width: "100%",
      padding: "12px",
      marginTop: "10px",
      border: "1px solid #ccc",
      borderRadius: "8px",
      fontSize: "15px",
      boxSizing: "border-box",
      outline: "none",
    },

    passwordContainer: {
      position: "relative",
    },

    showButton: {
      position: "absolute",
      right: "12px",
      top: "50%",
      transform: "translateY(-20%)",
      border: "none",
      background: "none",
      color: "#007bff",
      cursor: "pointer",
      fontSize: "14px",
    },

    error: {
      color: "red",
      fontSize: "13px",
      marginTop: "5px",
    },

    options: {
      display: "flex",
      justifyContent: "space-between",
      alignItems: "center",
      marginTop: "15px",
      fontSize: "14px",
    },

    button: {
      width: "100%",
      padding: "12px",
      marginTop: "20px",
      backgroundColor: "#007bff",
      color: "#fff",
      border: "none",
      borderRadius: "8px",
      fontSize: "16px",
      cursor: "pointer",
      fontWeight: "bold",
    },

    link: {
      color: "#007bff",
      textDecoration: "none",
      cursor: "pointer",
    },

    footer: {
      marginTop: "20px",
      textAlign: "center",
      fontSize: "14px",
      color: "#666",
    },
  };

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });

    setErrors({
      ...errors,
      [e.target.name]: "",
    });
  };

  const validate = () => {
    let tempErrors = {};

    if (!formData.username.trim()) {
      tempErrors.username = "Username is required";
    }

    if (!formData.password) {
      tempErrors.password = "Password is required";
    } else if (formData.password.length < 6) {
      tempErrors.password = "Password must be at least 6 characters";
    }

    return tempErrors;
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    const validationErrors = validate();
    setErrors(validationErrors);

    if (Object.keys(validationErrors).length === 0) {
      alert("Login Successful!");

      setFormData({
        username: "",
        password: "",
      });

      setRememberMe(false);
      setShowPassword(false);
      setErrors({});
    }
  };

  return (
    <div style={styles.page}>
      <div style={styles.container}>
        <h2 style={styles.title}>Login Form</h2>

        <p style={styles.subtitle}>
          Welcome to Authentication page. <br/> Please login in to continue.
        </p>

        <form onSubmit={handleSubmit}>
          <input
            type="text"
            name="username"
            placeholder="Enter Username"
            value={formData.username}
            onChange={handleChange}
            style={styles.input}
            onFocus={(e) => (e.target.style.border = "1px solid #007bff")}
            onBlur={(e) => (e.target.style.border = "1px solid #ccc")}
          />

          {errors.username && (
            <div style={styles.error}>{errors.username}</div>
          )}

          <div style={styles.passwordContainer}>
            <input
              type={showPassword ? "text" : "password"}
              name="password"
              placeholder="Enter Password"
              value={formData.password}
              onChange={handleChange}
              style={styles.input}
              onFocus={(e) => (e.target.style.border = "1px solid #007bff")}
              onBlur={(e) => (e.target.style.border = "1px solid #ccc")}
            />

            <button
              type="button"
              style={styles.showButton}
              onClick={() => setShowPassword(!showPassword)}
            >
              {showPassword ? "Hide" : "Show"}
            </button>
          </div>

          {errors.password && (
            <div style={styles.error}>{errors.password}</div>
          )}

          <div style={styles.options}>
            <label>
              <input
                type="checkbox"
                checked={rememberMe}
                onChange={() => setRememberMe(!rememberMe)}
              />{" "}
              Remember Me
            </label>

            <a href="#" style={styles.link}>
              Forgot Password?
            </a>
          </div>

          <button
            type="submit"
            style={styles.button}
            onMouseOver={(e) =>
              (e.target.style.backgroundColor = "#0056b3")
            }
            onMouseOut={(e) =>
              (e.target.style.backgroundColor = "#007bff")
            }
          >
            Login
          </button>
        </form>

        <div style={styles.footer}>
          Don't have an account?{" "}
          <span style={styles.link}> <a href="#" style={styles.link}>
              Register
            </a></span>
        </div>
      </div>
    </div>
  );
}
export default AuthenForm;