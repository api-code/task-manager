document.addEventListener("DOMContentLoaded", function () {
  // DOM elements
  const taskForm = document.getElementById("createTaskForm");
  const taskList = document.getElementById("taskList");

  // Event listener for submitting the task creation form
  taskForm.addEventListener("submit", function (e) {
    e.preventDefault();

    const formData = new FormData(taskForm);
    const taskData = {
      name: formData.get("name"),
      description: formData.get("description"),
      status: formData.get("status")
    };

    // Send a POST request to create a new task
    fetch("http://localhost:8080/api/tasks", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(taskData),
    })
      .then((response) => response.json())
      .then((data) => {
        // Add the new task to the task list
        const taskItem = document.createElement("li");
        taskItem.innerHTML = `
                    ${data.title} - ${data.description}-${data.status}
                    <button class="delete-button" data-id="${data.id}">Delete</button>
                `;
        taskList.appendChild(taskItem);

        // Clear the form inputs
        taskForm.reset();
      })
      .catch((error) => console.error("Error creating task:", error));
  });

  // Event listener for deleting a task
  taskList.addEventListener("click", function (e) {
    if (e.target.classList.contains("delete-button")) {
      const taskId = e.target.getAttribute("data-id");

      // Send a DELETE request to delete the task by ID
      fetch(`/tasks/${taskId}`, {
        method: "DELETE",
      })
        .then(() => {
          // Remove the task item from the list
          e.target.parentElement.remove();
        })
        .catch((error) => console.error("Error deleting task:", error));
    }
  });

  // Function to load and display tasks from the server
  function loadTasks() {
    // Send a GET request to retrieve all tasks
    fetch("http://localhost:8080/api/tasks")
      .then((response) => response.json())
      .then((data) => {
        taskList.innerHTML = ""; // Clear the task list

        // Add each task to the task list
        data.forEach((task) => {
          const taskItem = document.createElement("li");
          taskItem.innerHTML = `
                        ${task.name} - ${task.description}
                        <button class="delete-button" data-id="${task.id}">Delete</button>
                    `;
          taskList.appendChild(taskItem);
        });
      })
      .catch((error) => console.error("Error loading tasks:", error));
  }

  // Load and display tasks when the page loads
  loadTasks();
});
